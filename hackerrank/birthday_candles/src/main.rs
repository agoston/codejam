use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let _num_candles: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();

    let count = lines
        .next()
        .unwrap()
        .unwrap()
        .split_whitespace()
        .map(|v| v.trim().parse().unwrap())
        .fold((0, 0), |acc: (u32, u32), v: u32| {
            if v > acc.0 {
                (v,1)
            } else if v == acc.0 {
                (acc.0, acc.1+1)
            } else {
                acc
            }
        });

    println!("{}", count.1);
}
