use std::io::{self, BufRead};

fn work(l: u32, r: u32) -> u32 {
    // 0101
    // 1111
    // can this be calculated programatically? ...
    // max is 0101 + 1010 -> 1111
    // 1. 0+1, ok
    // 2. l can't be 0, r can be 0 -> 1+0, ok
    // 3. 0+1, ok
    // 4. l can't be 0, r can be 0 -> ok
    // but
    // 2. if l is zero, first bit is 1 -> recursion?

    // =======> doable, but complex. implementing stupid trial-error first.

    let mut max = 0u32;

    for i in l..=r {
        for j in i+1..=r {
            let xored = i ^ j;
            if xored > max {
                max = xored;
            }
        }
    }
    max
}

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let l: u32 = lines.next().unwrap().unwrap().trim().parse().unwrap();
    let r: u32 = lines.next().unwrap().unwrap().trim().parse().unwrap();

    println!("{}", work(l, r));
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_work() -> Result<(), String> {
        assert_eq!(work(10, 15), 7);
        Ok(())
    }

    #[test]
    fn test_corner() -> Result<(), String> {
        assert_eq!(work(10, 10), 0);
        Ok(())
    }
}
