package list.arraylist.implementation;

import java.util.Arrays;

public class ArrayList {

	private int size = 0;
	private Object[] elementData = new Object[100];
	
	//1. 데이터 추가
	//1-1. 첫번째 위치에 데이터 추가
	public boolean addFirst(Object element) {
		
		return add(0, element);
	}
	
	//1-2. 마지막 위치에 데이터 추가
	public boolean addLast(Object element) {
		
		elementData[size] = element;
		size++;
		
		return true;
	}

	//1-3. 원하는 위치에 데이터 추가
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
			
			if(i < size-1) {	//마지막에는 ,를 넣지말자
				str += ",";				
			}
		}
		
		return str + "]";
	}
	
	
	//2. 데이터 삭제
	//2-1. 원하는 위치의 데이터 삭제
	public Object remove(int index) {
		
		Object removed = elementData[index];
		
		for (int i=index+1; i <= size-1; i++) {
			elementData[i-1] = elementData[i];
		}
		
		size--;
		
		//마지막 위치의 엘리먼트를 명시적으로 삭제
		elementData[size] = null;
		
		return removed;
	}
	
	
	//2-2. 첫번째 데이터 삭제
	public Object removeFirst() {
		
		return remove(0);
	}
	

	//2-3. 마지막 데이터 삭제
	public Object removeLast() {
		
		return remove(size-1);
	}
	
	
	//3. 특정 엘리먼트의 값 가져오기
	public Object get(int index) {
		return elementData[index];
	}
	
	
	//4. 엘리먼트의 크기 가져오기
	public int size() {
		
		return size;
	}
	

	/**
	 * 5. 데이터 탐색
	 * 	- 특정한 값을 가진 엘리먼트의 인덱스 값을 알아내는 방법
	 * @param o
	 * @return 해당 값이 있다면 그 값이 발견되는 첫번째 인덱스값, 없다면 -1을 return
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
		//ListIterator 인스턴스를 생성해서 리턴한다.
		return new ListIterator();
	}
	
	
	class ListIterator {
		
		private int nextIndex = 0;

		/**
		 * 다음 엘리먼트의 존재 여부를 반환하는 메소드
		 * @return 존재하면 1, 안하면 0
		 */
		public boolean hasNext() {
			return nextIndex < size;
		}
		
		/**
		 * 다음 엘리먼트를 찾는 메소드
		 * @return nextIndex에 해당하는 엘리먼트를 반환한다.
		 */
		public Object next() {
			//해당 엘리먼트 리턴 후 nextIndex의 값을 1 증가
			return elementData[nextIndex++];
		}
		
		
		/**
		 * 이전의 엘리먼트를 찾는 메소드
		 * @return previousIndex에 해당하는 엘리먼트를 반환한다.
		 */
		public Object previous() {
			//해당 엘리먼트 리턴 후 nextIndex의 값을 1 감소
			return elementData[--nextIndex];
		}

		/**
		 * 이전 엘리먼트의 존재 여부를 반환하는 메소드
		 * @return 1이면 이전 엘리먼트 존재, 0이면 존재하지 않음
		 */
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		/**
		 * 현재 엘리먼트를 추가한다.
		 * @param element
		 */
		public void add(Object element) {
			ArrayList.this.add(nextIndex++, element);	
		}
		
		
		/**
		 * 현재 엘리먼트를 삭제한다.
		 */
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}

	}
	

}
