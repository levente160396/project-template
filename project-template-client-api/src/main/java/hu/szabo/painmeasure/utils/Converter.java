package hu.szabo.painmeasure.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.util.CollectionUtils;

public class Converter {

	private Converter() {
	}

	public static <T> Set<T> convertListToSet(List<T> list) {
		Set<T> set = new HashSet<>();

		for (T t : list) {
			set.add(t);
		}

		return set;
	}

	public static <T> List<T> convertSetToList(Set<T> set) {
		List<T> list = new LinkedList<>();

		for (T t : set) {
			list.add(t);
		}

		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static  <K, V> Map<K, V> convertListObjectArrayToMap(List<Object[]> dataArray) {
		
		if (CollectionUtils.isEmpty(dataArray)) {
			return Collections.emptyMap();
		}
		
		Map<K, V> results = new TreeMap<>();
		
		for (Object[] tmp : dataArray) {
			results.put((K)tmp[0], (V)tmp[1]);
		}
		
		return results;	
	}
}
