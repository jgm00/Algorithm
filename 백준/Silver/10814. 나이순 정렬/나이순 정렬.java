import java.io.*;
import java.util.*;

public class Main {
	static int N;

	static class Student implements Comparable<Student> {
		int idx;
		int age;
		String name;

		Student(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Student o1) {
			if (this.age == o1.age) {
				return this.idx - o1.idx;
			}
			return this.age - o1.age; // 오름차순
		}
	}

	static Student[] students;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		students = new Student[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			students[i] = new Student(i, Integer.parseInt(st.nextToken()), st.nextToken());
		}
		Arrays.sort(students);
		for (int i = 0; i < N; i++) {
			System.out.println(students[i].age + " " + students[i].name);
		}
	}
}
