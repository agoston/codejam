pub fn nth(n: u32) -> u32 {
    let mut look_n: u32 = 0;
    let mut prime: u32 = 2;

    loop {
        if is_prime(prime) {
            if n == look_n {
                return prime;
            }

            look_n += 1;
        }
        prime += 1;
    }
}

fn is_prime(prime: u32) -> bool {
    for i in 2..=prime / 2 {
        if prime % i == 0 {
            return false;
        }
    }
    return true;
}
