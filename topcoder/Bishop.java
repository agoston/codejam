public class Bishops {
public static char[][] b = null;
public static int s;
public static int ind = 0, px = 0, py = 0;
public static int found = 0;
public static int[] kx = null;
public static int[] ky = null;

public static final void printb() {
	for (int i = 0; i < s; i++) {
		for (int j = 0; j < s; j++) {
			System.out.print(b[i][j]);
		}
		System.out.println();
	}
	System.out.println();
}

public static final char getField(int x, int y) {
	return b[y][x];
}

public static final void setField(int x, int y, char c) {
	b[y][x] = c;
}

public static final boolean next() {
	px++;
	if (px >= s) {
		py++;
		px = 0;
		if (py >= s) {
			return false;
		}
	}
	return true;
}

public static final boolean canPlace(int x, int y) {
	if (getField(x, y) != '.') return false;
	
	int ox = x, oy = y;
	x=ox-1; y=oy-1;
	while (x >= 0 && x < s && y >= 0 && y < s) {
		if (getField(x,y) == 'x') return false;
		x--; y--;
	} 
	
	x=ox+1;y=oy-1;
	while (x >= 0 && x < s && y >= 0 && y < s) {
		if (getField(x,y) == 'x') return false;
		x++; y--;
	} 

	x=ox+1;y=oy+1;
	while (x >= 0 && x < s && y >= 0 && y < s) {
		if (getField(x,y) == 'x') return false;
		x++; y++;
	} 

	x=ox-1;y=oy+1;
	while (x >= 0 && x < s && y >= 0 && y < s) {
		if (getField(x,y) == 'x') return false;
		x--; y++;
	} 
	
	return true;
}

public int count(int k, String[] board) {
	if (k == 0) return 1;
	s = board.length;
	b = new char[s][];
	for (int i = 0; i < s; i++) {
		b[i] = new char[s];
		for (int j = 0; j < s; j++) {
			b[i][j] = board[i].charAt(j);
		}
	}

	kx = new int[k];
	ky = new int[k];
	
	// elso felrakas
	for (int i = 0; i < k; i++) {
		while (!canPlace(px, py)) {
			if (!next()) {
				return 0;
			}
		}
		kx[i] = px;
		ky[i] = py;
		setField(px, py, 'x');
	}

	//printb();
	
	k--;
	ind = k;
	found = 1;
	setField(kx[ind], ky[ind], '.');
	
	while (true) {
		px = kx[ind]; py = ky[ind];
		while (next()) {
			//boolean bbb = canPlace(px, py);
			//System.out.println("Canplace "+ind+" to "+px+", "+py+": "+bbb);
			//if (bbb) {
			if (canPlace(px, py)) {
				kx[ind] = px; ky[ind] = py;
				if (ind == k) {
					found++;
					//setField(px, py, 'x');
					//printb();
					//setField(px, py, '.');
					continue;
				
				} else {
					setField(px, py, 'x');
					ind++;
					kx[ind] = px; ky[ind] = py;
					continue;
				}
			}
		} 

		ind--;
		if (ind < 0) return found;
		setField(kx[ind], ky[ind], '.');
	}
	
}

}
