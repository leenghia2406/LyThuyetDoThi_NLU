package tuan1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Graph {
	protected int numberOfVexs;
	protected int[][] matrixAdj;
	protected static String pathFile = "D:\\JavaTN\\LyThuyetDoThi\\src\\tuan1\\test1.txt";
	
	public Graph() {
		super();
	}

	public boolean loadGraph(String pathFile) throws IOException {
	    File f = new File(pathFile);
	    BufferedReader br = new BufferedReader(new FileReader(f));
	    String firstLine = br.readLine();
	    this.numberOfVexs = Integer.parseInt(firstLine);
	    this.matrixAdj = new int[numberOfVexs][numberOfVexs]; 
	    String line = "";
	    int indexRows = 0;
	    while ((line = br.readLine()) != null) {
	        String[] row = line.split(" ");
	        for (int i = 0; i < numberOfVexs; i++) {
	            this.matrixAdj[indexRows][i] = Integer.parseInt(row[i]);
	        }
	        indexRows++;
	    }
	    return true;
	}

	public void printMatrix(int[][]matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	public void printMatrix() {
		// implement code
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj.length; j++) {
				System.out.print(matrixAdj[i][j]+ " ");
			}
			System.out.println();
		}
	}
	@Override
	public String toString() {
		return "Graph [numberOfVexs=" + numberOfVexs + ", matrixAdj=" + Arrays.toString(matrixAdj) + "]";
	}
	public boolean checkValid() { 
		// implement code
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj.length; j++) {
				if (matrixAdj[i][j] > 1 || matrixAdj[i][i] != 0) { 
					return false; 
				}
			}
		}
		return true;
	}
	public boolean checkUnGraph(){
		// implement code
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj.length; j++) {
				if (matrixAdj[i][j] != matrixAdj[j][i]) {
					return false; // Directed Graph
				}
			}
		}
		return true;
	}
	public abstract void addEdge (int v1, int v2);
	public abstract void removeEdge (int v1, int v2);
	public int deg(int v) {
		if(v < 0 || v > numberOfVexs) {
			System.out.println("Dinh khong hop le");
			return -1;
		}
		int degree = 0;
		for (int i = 0; i < matrixAdj.length; i++) {
//			tong cac phan tu cua hang v la bac cua v
	            degree += matrixAdj[v - 1][i];
	        }
	        return degree;
	}
	public int sumDeg() {
		// implement code
		int totalDeg = 0;
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj.length; j++) {
				totalDeg += matrixAdj[i][j];
			}
		}
		return totalDeg;
	}
	public int numVertexs() {
	// implement code
		return matrixAdj.length;
	}
	public int numEdges(){
	// implement code
		int totalEdge = 0;
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj.length; j++) {
				if (matrixAdj[i][j] == 1) {
					totalEdge += 1;
				}
			}
		}
		return totalEdge / 2; // khong can chia hai neu la do thi co huong
	}
	
}
