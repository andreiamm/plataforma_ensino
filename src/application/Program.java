package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Dados da " + i +"a aula:");
			System.out.print("Conte�do ou tarefa (c/t)? ");
			char lessonType = sc.next().charAt(0);
			System.out.print("T�tulo: ");
			sc.nextLine();
			String title = sc.nextLine();
			
			if (lessonType == 'c' || lessonType == 'C') {
				System.out.print("URL do v�deo: ");
				String url = sc.nextLine();
				System.out.print("Dura��o em segundos: ");
				int duration = sc.nextInt();
				list.add(new Video(title, url, duration));
			} else {
				System.out.print("Descri��o: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de quest�es: ");
				int questions = sc.nextInt();
				list.add(new Task(title, description, questions));
			}
		}
		
		int sum = 0;
		for (Lesson l : list) {
			sum += l.duration();
		}
		
		System.out.println();
		System.out.printf("DURA��O TOTAL DO CURSO = %d segundos", sum);
		
		sc.close();
	}

}
