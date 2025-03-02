package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;
import java.io.*;

class 섬지키기_Solution {
	private final static int CMD_INIT = 1;
	private final static int CMD_NUMBER_OF_CANDIDATE = 2;
	private final static int CMD_MAX_AREA = 3;

	private final static UserSolution usersolution = new UserSolution();

	private static int[][] mMap = new int[20][20];
	private static int[] mStructure = new int[5];

	private static boolean run(BufferedReader br) throws Exception {
		StringTokenizer st;

		int numQuery;
		int N, M, mSeaLevel;
		int userAns, ans;

		boolean isCorrect = false;

		numQuery = Integer.parseInt(br.readLine());

		for (int q = 0; q < numQuery; ++q) {
			st = new StringTokenizer(br.readLine(), " ");

			int cmd;
			cmd = Integer.parseInt(st.nextToken());

			switch (cmd) {
			case CMD_INIT:
				N = Integer.parseInt(st.nextToken());
				for (int i = 0; i < N; i++)
					for (int j = 0; j < N; j++)
						mMap[i][j] = Integer.parseInt(st.nextToken());
				usersolution.init(N, mMap);
				isCorrect = true;
				break;
			case CMD_NUMBER_OF_CANDIDATE:
				M = Integer.parseInt(st.nextToken());
				for (int i = 0; i < M; i++)
					mStructure[i] = Integer.parseInt(st.nextToken());
				userAns = usersolution.numberOfCandidate(M, mStructure);
				ans = Integer.parseInt(st.nextToken());
				if (userAns != ans) {
					isCorrect = false;
				}
				break;
			case CMD_MAX_AREA:
				M = Integer.parseInt(st.nextToken());
				for (int i = 0; i < M; i++)
					mStructure[i] = Integer.parseInt(st.nextToken());
				mSeaLevel = Integer.parseInt(st.nextToken());
				userAns = usersolution.maxArea(M, mStructure, mSeaLevel);
				ans = Integer.parseInt(st.nextToken());
//				System.out.println("userAns :" + userAns + "ans : " + ans);
				if (userAns != ans) {
					isCorrect = false;
				}
				break;
			default:
				isCorrect = false;
				break;
			}
		}
		return isCorrect;
	}

	public static void main(String[] args) throws Exception {
		int TC, MARK;

		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TC = Integer.parseInt(st.nextToken());
		MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}

class UserSolution {
	static int myN;
	static int[][] mymMap;
	static int[][] modifiedMap;
	static int hash;
	static int revhash;

	static class Info {
		int r;
		int c;
		boolean isP; // 수평이면 True, 수직이면 false
		boolean isR; // 정방향이면 True, 역방향이면 False

		Info(int r, int c, boolean isP, boolean isR) {
			this.r = r;
			this.c = c;
			this.isP = isP;
			this.isR = isR;
		}
	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Info>[] alist;
	static Queue<Pair> q;
	static int mymSeaLevel;

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int[][] vis;

	public void init(int N, int mMap[][]) {
		myN = N;
		mymMap = new int[N][N];
		modifiedMap = new int[N][N];
		alist = new ArrayList[10000];
		for (int i = 0; i < 10000; i++) {
			alist[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				modifiedMap[i][j] = mymMap[i][j] = mMap[i][j];
			}
		}
		for (int len = 2; len <= 5; len++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - len + 1; j++) {
					hash = 0;
					revhash = 0;
					for (int k = 0; k < len - 1; k++) {
						hash = hash * 10 + (mymMap[i][j + k + 1] - mymMap[i][j + k] + 5);
					}
					alist[hash].add(new Info(i, j, true, true));
					for (int k = len - 2; k >= 0; k--) {
						revhash = revhash * 10 + (-mymMap[i][j + k + 1] + mymMap[i][j + k]) + 5;
					}
					if (revhash != hash) {
						alist[revhash].add(new Info(i, j, true, false));
					}
				}
				for (int j = 0; j < N - len + 1; j++) {
					hash = 0;
					revhash = 0;
					for (int k = 0; k < len - 1; k++) {
						hash = hash * 10 + (mymMap[j + k + 1][i] - mymMap[j + k][i]) + 5;
					}
					alist[hash].add(new Info(j, i, false, true));
					for (int k = len - 2; k >= 0; k--) {
						revhash = revhash * 10 + (-mymMap[j + k + 1][i] + mymMap[j + k][i]) + 5;
					}
					if (revhash != hash) {
						alist[revhash].add(new Info(j, i, false, false));
					}
				}
			}
		}
	}

	public int numberOfCandidate(int M, int mStructure[]) {
		int thash = 0;
		int ans = 0;
		if (M == 1) {
			return myN * myN;
		}
		for (int i = 0; i < M - 1; i++) {
			thash = thash * 10 + (mStructure[i] - mStructure[i + 1]) + 5;
		}
		return alist[thash].size();
	}

	static int checks(int[][] myMoMap) {
		q = new LinkedList<>();
		vis = new int[myN][myN];
		for (int i = 0; i < myN; i++) {
			for (int j = 0; j < myN; j++) {
				if (i == 0 || j == 0 || i == myN - 1 || j == myN - 1) {
					if (myMoMap[i][j] < mymSeaLevel) {
						q.add(new Pair(i, j));
						vis[i][j] = 1;
					}
				}
			}
		}
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int cx = p.x;
			int cy = p.y;
			for (int dir = 0; dir < 4; dir++) {
				int nx = dx[dir] + cx;
				int ny = dy[dir] + cy;
				if (nx >= 0 && ny >= 0 && nx < myN && ny < myN && vis[nx][ny] == 0) {
					if (myMoMap[nx][ny] < mymSeaLevel) {
						q.add(new Pair(nx, ny));
						vis[nx][ny] = 1;
					}
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < myN; i++) {
			for (int j = 0; j < myN; j++) {
				if (vis[i][j] == 0) {
					ret++;
				}
			}
		}
		return ret;
	}

	public int maxArea(int M, int mStructure[], int mSeaLevel) {
		mymSeaLevel = mSeaLevel;
		int mx = 0;
		int thash = 0;
		for (int i = 0; i < myN; i++) {
			for (int j = 0; j < myN; j++) {
				modifiedMap[i][j] = mymMap[i][j];
			}
		}
		for (int i = 0; i < M - 1; i++) {
			thash = thash * 10 + (mStructure[i] - mStructure[i + 1]) + 5;
		}
		if (alist[thash].size() == 0 && M != 1) {
			return -1;
		}
		for (int i = 0; i < alist[thash].size(); i++) {
			Info info = alist[thash].get(i);
			if (info.isP == false) {
				if (info.isR == true) {
					for (int k = 0; k < M; k++) {
						modifiedMap[info.r + k][info.c] += mStructure[k];
					}
					mx = Math.max(mx, checks(modifiedMap));
				} else {
					for (int k = M - 1; k >= 0; k--) {
						modifiedMap[info.r + k][info.c] += mStructure[M - k - 1];
					}
					mx = Math.max(mx, checks(modifiedMap));
				}
			} else {
				if (info.isR == true) {
					for (int k = 0; k < M; k++) {
						modifiedMap[info.r][info.c + k] += mStructure[k];
					}
					mx = Math.max(mx, checks(modifiedMap));
				} else {
					for (int k = M - 1; k >= 0; k--) {
						modifiedMap[info.r][info.c + k] += mStructure[M - k - 1];
					}
					mx = Math.max(mx, checks(modifiedMap));
				}
			}
			for (int ii = 0; ii < myN; ii++) {
				for (int j = 0; j < myN; j++) {
					modifiedMap[ii][j] = mymMap[ii][j];
				}
			}
		}
		if (M == 1) {
			for (int i = 0; i < myN; i++) {
				for (int j = 0; j < myN; j++) {
					modifiedMap[i][j] += mStructure[0];
					mx = Math.max(mx, checks(modifiedMap));
					modifiedMap[i][j] -= mStructure[0];
				}
			}
		}
		return mx;
	}
}