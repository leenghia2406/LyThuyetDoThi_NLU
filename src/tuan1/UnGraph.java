package tuan1;

import java.io.IOException;

public class UnGraph extends Graph{
	public static void main(String[] args) throws IOException {
		Graph unGraph = new UnGraph();
		if(unGraph.loadGraph(pathFile) == true) {
			System.out.println("Doc file thanh cong");
			unGraph.printMatrix();
			System.out.println(unGraph.checkValid() == true ? "Do thi hop le" : "Do thi khong hop le");
			System.out.println(unGraph.checkUnGraph() == true ? "Do thi vo huong" : "Do thi co huong");
			System.out.println("Tong bac cua do thi la: " + unGraph.sumDeg());
			System.out.println("Tong bac cua dinh 4 la: " + unGraph.deg(4));
			unGraph.addEdge(3, 3);
			unGraph.printMatrix();
			unGraph.removeEdge(2, 1);
			unGraph.printMatrix();
			System.out.println("Tong dinh cua ma tran la: " + unGraph.numVertexs());
		}else {
			System.out.println("Doc file khong thanh cong");
		}
		
	}

	@Override
	public void addEdge(int v1, int v2) {
		// TODO Auto-generated method stub
			// implement code
//		Kiem tra neu hai dinh duoc them nam ngoai do thi thi khong hop le
			if ((v1 < 0 || v2 < 0) || (v1 > numberOfVexs || v2 > numberOfVexs)) {
				System.out.println("Dinh khong hop le");;
				return;
			}
			matrixAdj[v1][v2] = matrixAdj[v2][v1] = 1;	// hai canh moi canh se = 1
			System.out.println("Canh ton tai giua " + v1 + " va " + v2 + " duoc them thanh cong");
	}

	@Override
	public void removeEdge(int v1, int v2) {
		// TODO Auto-generated method stub
//		Kiem tra neu hai dinh duoc them nam ngoai do thi thi khong hop le
		    if (v1 < 0 || v1 >= numberOfVexs || v2 < 0 || v2 >= numberOfVexs) {
		        System.out.println("Dinh khong hop le");
		        return;
		    }
		    if (matrixAdj[v1][v2] == 0) {
		        System.out.println("Canh khong ton tai giua " + v1 + " va " + v2);
		        return;
		    }
		    matrixAdj[v1][v2] = matrixAdj[v2][v1] = 0;
		    System.out.println("Canh ton tai giua " + v1 + " va " + v2 + " xoa thanh cong");
	}
	
	

}
