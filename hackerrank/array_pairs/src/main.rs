use std::io::{self, BufRead};

fn work(array: &Vec<u64>) -> u64 {
    let mut count = 0u64;

    for i in 0..array.len() {
        let mut max = array[i];
        for j in i + 1..array.len() {
            // calculating max value on the go, cheap
            if array[j] > max {
                max = array[j]
            }

            if array[i] * array[j] <= max {
                count += 1;
            }
        }
    }

    count
}

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let _: u32 = lines.next().unwrap().unwrap().trim().parse().unwrap();
    let array: Vec<u64> = lines
        .next()
        .unwrap()
        .unwrap()
        .trim()
        .split_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();

    println!("{}", work(&array));
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_work() -> Result<(), String> {
        assert_eq!(work(&vec![1, 1, 2, 4, 2]), 8);
        Ok(())
    }

    #[test]
    fn test_huge() -> Result<(), String> {
        
        Ok(())
    }
}
