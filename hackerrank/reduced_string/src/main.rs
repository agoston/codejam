use std::io::{self, BufRead};

fn iterate(input: &String) -> String {
    let mut buf = None::<char>;
    let mut acc = String::new();

    for ch in input.chars() {
        match buf {
            None => {
                buf = Some(ch)
            },
            Some(x) => if x == ch {
                buf = None
            } else {
                acc.push(x);
                buf = Some(ch)
            }
        }
    }
    acc.extend(buf);
    acc
}

fn work(input: String) -> String {
    let mut original = input;
    loop {
        let munged = iterate(&original);
        
        if munged.len() == original.len() {
            return munged;
        }

        original = munged;
    }
}

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let input = lines.next().unwrap().unwrap().trim().to_string();
    let result = work(input);
    if result.is_empty() {
        println!("Empty String");
    } else {
        println!("{}", result);
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_munge() -> Result<(), String> {
        assert_eq!(work("aaabccddd".to_string()), "abd");
        Ok(())
    }
}
