import java.util.*;
import java.io.*;

public class Main {
	static int N, M, map[][], count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		boolean visit[] = new boolean[N + 1];
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int u = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		dfs(1, 0, new int[3]);
		System.out.println(count);
	}

	static void dfs(int val, int selidx, int sel[]) {
		if(selidx == 3) {
			if(map[sel[0]][sel[1]]==1 || map[sel[1]][sel[2]]==1 || map[sel[0]][sel[2]]==1) 
				return;
			count++;
			return;
		}
		if(val == N+1)
			return;
		sel[selidx] = val;
		dfs(val+1, selidx+1, sel);
		dfs(val+1, selidx, sel);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
