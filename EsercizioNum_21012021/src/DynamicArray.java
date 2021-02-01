public class DynamicArray {
	private int[] array;
	private int numEl;// Il numero di elementi
	public DynamicArray(int n) {
		array = new int[n];
	}
	// Rimuove gli elementi in eccesso dell'array
	public void trim() {
		if (numEl < array.length) {
			int[] arr1 = new int[numEl];
			for (int i = 0; i < numEl; i++) {
				arr1[i] = array[i];
			}
			array = arr1;
		}
	}
// Inserisce elem nella prima posizione disponibile  
	public void add(int elem) {
		if (numEl == array.length) {
			int[] arr1 = new int[array.length * 2];
			for (int i = 0; i < numEl; i++) {
				arr1[i] = array[i];
			}
			array = arr1;
		}
		array[numEl++] = elem;
	}
// Inserisce elem nella posizione pos
	public void insert(int pos, int elem) throws InsertException {
		if (pos > numEl || pos < 0) {
			throw new InsertException();
		}
		if (numEl == array.length) {
			int[] arr1 = new int[array.length * 2];
			for (int i = 0; i < numEl; i++) {
				arr1[i] = array[i];
			}
			array = arr1;
		}
		for (int i = numEl; i > pos; i--) {
			array[i] = array[i - 1];
		}
		array[pos] = elem;
		numEl++;
	}
// Rimuove l'elemento elem qualora fosse in array
	public void remove(int elem) throws RemoveException {
		boolean found = false;
		for (int i = 0; i < numEl; i++) {
			if (elem == array[i]) {
				found = true;
				for (; i < numEl - 1; i++) { // Utilizza i per shiftare gli elementi verso sinistra
					array[i] = array[i + 1];
				}
				numEl--;
				break;
			}
		}
		if (!found) {
			throw new RemoveException();
		}
	}
	@Override
	public String toString() {
		String str = "[";
		for (int i = 0; i < numEl - 1; i++) {
			str += (array[i] + " ");
		}
		str += (array[numEl - 1] + "]\n");
		return str;
	}
}