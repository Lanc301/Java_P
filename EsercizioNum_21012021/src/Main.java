/*
1) classe DynamicArray:
2) costruttore:
   DynamicArray(N), dove "N" = dimensione massima 
   dell'array 
   (*)
3) metodo Add():
   aggiunge un elemento alla fine dell'array
   (**)
4) metodo Insert(n, v):
   inserisce il valore "v" nell'elemento in posizione
   "n" 
   (***)
5) metodo Remove(v):
   elimimina l'elemento il cui valore � uguale a "v"
   (****)
6) metodo Trim():
 	 riduce la dimensione dell'array, "N", ad "M"
NOTE
(*): in una variabile di istanza, mantenere il "M" 
     numero di elementi effettivamente occupati 
     nell'array
(**):nel caso in cui l'array sia gi� pieno:
   	 restituire false, oppure raddoppiare 
   	 le dimensioni dell'array
(***): nel caso in cui "n" sia maggiore di "M", resituire false
(****): nel caso in cui il valore non sia presente nell'array, restituire false
 */
public class Main {

	public static void main(String[] args) {
		dynamicArrTest();
	}

	static void dynamicArrTest() {
		int N = 4;
		DynamicArray arr = new DynamicArray(N);

		arr.add(1);
		arr.add(16);
		arr.add(-7);
		try {
			arr.insert(1, -5);
		} catch (InsertException e) {
			System.out.println("Eccezione: " + e);
		}
		System.out.println(arr);
		try {
			arr.insert(6, 10);
		} catch (InsertException e) {
			System.out.println("Eccezione: " + e);
		}
		arr.add(13);
		System.out.println(arr);
		try {
			arr.remove(16);
		} catch (RemoveException e) {
			System.out.println("Eccezione: " + e);
		}
		System.out.println(arr);
		try {
			arr.remove(0);
		} catch (RemoveException e) {
			System.out.println("Eccezione: " + e);
		}
		System.out.println(arr);
		arr.trim();
		return;
//		stampaArray(arr, arr.getM());
//		System.out.println(arr);
	}

//	private static void stampaArray( DynamicArray a, int n) {
//		for(int i = 0; i < n; i++) {
//			System.out.print(a[i]);			
//		}
//	}
}
