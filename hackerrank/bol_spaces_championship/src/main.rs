use std::io::{self, BufRead};

fn walk_and_remove_block(y: usize, x: usize, map: &mut Vec<Vec<u8>>) {
    if map[y][x] == 0 {
        return;
    }
    map[y][x] = 0;
    if y > 0 {
        walk_and_remove_block(y-1, x, map);
    }
    if x > 0 {
        walk_and_remove_block(y, x-1, map);   
    }
    if y < map.len() -1 {
        walk_and_remove_block(y+1, x, map);
    }
    if x < map[y].len()-1 {
        walk_and_remove_block(y, x+1, map);
    }
}

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let grid_rows: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();
    let grid_cols: usize = lines.next().unwrap().unwrap().trim().parse().unwrap();

    let mut map: Vec<Vec<u8>> = Vec::new();

    for _ in 0..grid_rows {
        map.push(
            lines
                .next()
                .unwrap()
                .unwrap()
                .split_whitespace()
                .map(|v| v.trim().parse().unwrap())
                .collect()
        );
    }

    let mut count = 0;

    for y in 0..grid_rows {
        for x in 0..grid_cols {
            if map[y][x] != 0 {
                count += 1;
                walk_and_remove_block(y, x, &mut map);
            } 
        } 
    }

    println!("{}", count);

}
