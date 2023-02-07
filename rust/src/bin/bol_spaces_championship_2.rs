use std::io;

fn main() {
    let mut lines = io::stdin().lines();
    let grid_rows: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();
    let _grid_cols: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();

    let mut map: Vec<Vec<u8>> = Vec::new();

    for i in 0..grid_rows {
        map.push(
            lines
                .next()
                .unwrap()
                .unwrap()
                .split(" ")
                .map(|v| v.trim().parse().unwrap())
                .collect(),
        );
    }

    println!("Hello, world!");
}
