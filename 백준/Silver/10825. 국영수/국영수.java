import java.io.*;
import java.util.*;

public class Main {
	static int N;

	static class Student implements Comparable<Student> {
		String name;
		int Korean;
		int English;
		int Math;

		Student(String name, int Korean, int English, int Math) {
			this.name = name;
			this.Korean = Korean;
			this.English = English;
			this.Math = Math;
		}

		@Override
		public int compareTo(Student st1) {
			if (st1.Korean == Korean) {
				if (st1.English == English) {
					if (st1.Math == Math) {
						return name.compareTo(st1.name);
					}
					return st1.Math - Math;
				}
				return English - st1.English;
			}
			return st1.Korean - Korean;
		}
	}
	
	static Student[] students;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		students = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int Korean = Integer.parseInt(st.nextToken());
			int English = Integer.parseInt(st.nextToken());
			int Math = Integer.parseInt(st.nextToken());
			
			Student student = new Student(name, Korean, English, Math);
			students[i] = student;
		}
		Arrays.sort(students);
		
		for(int i=0;i<N;i++) {
			System.out.println(students[i].name);
		}
	}
}
