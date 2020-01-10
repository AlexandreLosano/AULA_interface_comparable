package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidade.Empregado;

public class Programa {

	public static void main(String[] args) {

		List<Empregado> lista = new ArrayList<>();
		String path = "C:\\temp\\in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String empregadoCSV = br.readLine();
			while (empregadoCSV != null) {
				String[] campo = empregadoCSV.split(",");
				lista.add(new Empregado(campo[0], Double.parseDouble(campo[1])));
				empregadoCSV = br.readLine();
			}
			Collections.sort(lista);
			for (Empregado emp : lista) {
				System.out.println(emp.getNome() + " , " + emp.getSalario());
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

		}

	}
}
