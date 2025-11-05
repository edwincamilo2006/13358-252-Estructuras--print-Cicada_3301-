public class BinarySearchTreeDemo {

	static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int value) {
			this.value = value;
		}
	}


	static class BinarySearchTree {

		TreeNode root;

		public TreeNode findValue(TreeNode current, int target) {
			if (current == null) {
				return null;
			}

			if (current.value == target) {
				return current;
			}

			if (target < current.value) {
				return findValue(current.left, target);
			} else {
				return findValue(current.right, target);
			}
		}


		public TreeNode find(int target) {
			return findValue(root, target);
		}


		public void insertNode(TreeNode current, int newValue) {
			if (newValue == current.value) {
				System.out.println("Valor duplicado");
				return;
			}

			if (newValue < current.value) {
				if(current.left != null) {
					insertNode(current.left, newValue);
				} else {
					current.left = new TreeNode(newValue);
					current.left.parent = current;
				}
			}  else {
				if(current.right != null) {
					insertNode(current.right, newValue);
				} else {
					current.right = new TreeNode(newValue);
					current.right.parent = current;
				}
			}
		}


		public void insert(int newValue) {
			if (root == null) {
				root = new TreeNode(newValue);
			} else {
				insertNode(root, newValue);
			}
		}


		// RECORRIDO IN-ORDER (Izquierda - Raíz - Derecha)
		private void inorderRec(TreeNode node) {
			if (node != null) {
				inorderRec(node.left);
				System.out.print(node.value + " ");
				inorderRec(node.right);
			}
		}

		public void inorder() {
			System.out.print("Recorrido in-order: ");
			inorderRec(root);
			System.out.println();
		}

		// RECORRIDO PRE-ORDER (Raíz - Izquierda - Derecha)
		private void preorderRec(TreeNode node) {
			if (node != null) {
				System.out.print(node.value + " ");
				preorderRec(node.left);
				preorderRec(node.right);
			}
		}

		public void preorder() {
			System.out.print("Recorrido pre-order: ");
			preorderRec(root);
			System.out.println();
		}

		// RECORRIDO POST-ORDER (Izquierda - Derecha - Raíz)
		private void postorderRec(TreeNode node) {
			if (node != null) {
				postorderRec(node.left);
				postorderRec(node.right);
				System.out.print(node.value + " ");
			}
		}

		public void postorder() {
			System.out.print("Recorrido post-order: ");
			postorderRec(root);
			System.out.println();
		}

		// Método auxiliar para encontrar el mínimo en un subárbol
		private TreeNode findMin(TreeNode node) {
			while (node.left != null) {
				node = node.left;
			}
			return node;
		}

		// DELETE - Eliminar un nodo del árbol
		private TreeNode deleteNode(TreeNode node, int value) {
			// Caso base: árbol vacío
			if (node == null) {
				return null;
			}

			// Buscar el nodo a eliminar
			if (value < node.value) {
				node.left = deleteNode(node.left, value);
				if (node.left != null) {
					node.left.parent = node;
				}
			} else if (value > node.value) {
				node.right = deleteNode(node.right, value);
				if (node.right != null) {
					node.right.parent = node;
				}
			} else {
				// Nodo encontrado - proceder a eliminarlo

				// Caso 1: Nodo hoja (sin hijos)
				if (node.left == null && node.right == null) {
					return null;
				}

				// Caso 2: Nodo con un solo hijo
				if (node.left == null) {
					return node.right;
				} else if (node.right == null) {
					return node.left;
				}

				// Caso 3: Nodo con dos hijos
				// Encontrar el sucesor in-order (mínimo del subárbol derecho)
				TreeNode successor = findMin(node.right);
				
				// Copiar el valor del sucesor al nodo actual
				node.value = successor.value;
				
				// Eliminar el sucesor
				node.right = deleteNode(node.right, successor.value);
				if (node.right != null) {
					node.right.parent = node;
				}
			}

			return node;
		}

		public void delete(int value) {
			root = deleteNode(root, value);
		}

	}


	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

		System.out.println("Creando árbol binario de búsqueda");

		int[] values = {8,3,10,1,6,14,4,7,13};

		for(int v : values) {
			tree.insert(v);
		}

		System.out.println("\n=== RECORRIDOS DEL ÁRBOL ===");
		tree.inorder();
		tree.preorder();
		tree.postorder();

		System.out.println("\n=== PRUEBAS DE ELIMINACIÓN ===");
		
		// Eliminar nodo hoja
		System.out.println("\nEliminando nodo hoja (4):");
		tree.delete(4);
		tree.inorder();

		// Eliminar nodo con un hijo
		System.out.println("\nEliminando nodo con un hijo (14):");
		tree.delete(14);
		tree.inorder();

		// Eliminar nodo con dos hijos
		System.out.println("\nEliminando nodo con dos hijos (3):");
		tree.delete(3);
		tree.inorder();

		// Eliminar la raíz
		System.out.println("\nEliminando la raíz (8):");
		tree.delete(8);
		tree.inorder();

		System.out.println("\n=== RECORRIDOS FINALES ===");
		tree.preorder();
		tree.postorder();
	}

}