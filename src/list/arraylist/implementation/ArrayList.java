package list.arraylist.implementation;

import java.util.Arrays;

public class ArrayList {

	private int size = 0;
	private Object[] elementData = new Object[100];
	
	//1. ������ �߰�
	//1-1. ù��° ��ġ�� ������ �߰�
	public boolean addFirst(Object element) {
		
		return add(0, element);
	}
	
	//1-2. ������ ��ġ�� ������ �߰�
	public boolean addLast(Object element) {
		
		elementData[size] = element;
		size++;
		
		return true;
	}

	//1-3. ���ϴ� ��ġ�� ������ �߰�
	public boolean add(int index, Object element) {
		
		for (int i=size-1; i>=index; i--) {
			elementData[i+1] = elementData[i];
		}
		
		elementData[index] = element;
		size++;

		return true;
	}

	
	@Override
	public String toString() {
		String str = "[";
		
		for(int i=0; i < size; i++) {
			str += elementData[i];
			
			if(i < size-1) {	//���������� ,�� ��������
				str += ",";				
			}
		}
		
		return str + "]";
	}
	
	
	//2. ������ ����
	//2-1. ���ϴ� ��ġ�� ������ ����
	public Object remove(int index) {
		
		Object removed = elementData[index];
		
		for (int i=index+1; i <= size-1; i++) {
			elementData[i-1] = elementData[i];
		}
		
		size--;
		
		//������ ��ġ�� ������Ʈ�� ��������� ����
		elementData[size] = null;
		
		return removed;
	}
	
	
	//2-2. ù��° ������ ����
	public Object removeFirst() {
		
		return remove(0);
	}
	

	//2-3. ������ ������ ����
	public Object removeLast() {
		
		return remove(size-1);
	}
	
	
	//3. Ư�� ������Ʈ�� �� ��������
	public Object get(int index) {
		return elementData[index];
	}
	
	
	//4. ������Ʈ�� ũ�� ��������
	public int size() {
		
		return size;
	}
	

	/**
	 * 5. ������ Ž��
	 * 	- Ư���� ���� ���� ������Ʈ�� �ε��� ���� �˾Ƴ��� ���
	 * @param o
	 * @return �ش� ���� �ִٸ� �� ���� �߰ߵǴ� ù��° �ε�����, ���ٸ� -1�� return
	 */
	public Object indexOf(Object o) {
		
		for (int i=0; i < size; i++) {
			
			if (o.equals(elementData[i])) {
				
				return i;
			}
		}
		
		return -1;
	}
	
	
	
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	
	class ListIterator {
		
		private int nextIndex = 0;

		/**
		 * ���� ������Ʈ�� ���� ���θ� ��ȯ�ϴ� �޼ҵ�
		 * @return �����ϸ� 1, ���ϸ� 0
		 */
		public boolean hasNext() {
			return nextIndex < size;
		}
		
		/**
		 * ���� ������Ʈ�� ã�� �޼ҵ�
		 * @return 
		 */
		public Object next() {
			return elementData[nextIndex++];
		}
		
		
		/**
		 * ������ ������Ʈ�� ã�� �޼ҵ�
		 * @return
		 */
		public Object previous() {
			return elementData[--nextIndex];
		}

		/**
		 * ���� ������Ʈ�� ���� ���θ� ��ȯ�ϴ� �޼ҵ�
		 * @return
		 */
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);	
		}

	}
	

}
