package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

public class ListUtils {
	static Logger logger = Logger.getLogger(ListUtils.class.getName());

	// chops a list into non-view sublists of length L
	/*
	 * Chia 1 danh sach thanh N danh sach con voi moi danh sach co L phan tu vi du
	 * Size =1000 va L=100 --> danh sach chia thanh 10 danh sach con. moi con co 100
	 * phan tu.
	 */
	public static <T> List<List<T>> chopped(List<T> list, int totalFetcher, final int L) {
		List<List<T>> parts = new ArrayList<List<T>>();
		final int N = list.size();
		// Logs.infoTitle(conf, ListUtils.class, "N:" + N + "\tL:" + L);
		int j = 0;
		for (int i = 0; i < N; i += L) {
			j++;

			if (j < totalFetcher) {
				if (logger.isDebugEnabled())
					logger.debug("j:" + j + "<" + totalFetcher + "\t subList:(" + i + "," + (i + L) + ")");
				parts.add(new ArrayList<T>(list.subList(i, Math.min(N, i + L))));
			} else {
				if (logger.isDebugEnabled())
					logger.debug("j:" + j + "=" + totalFetcher + "\t subList:(" + i + "," + N + ")");
				parts.add(new ArrayList<T>(list.subList(i, N)));
				break;
			}

		}
		return parts;
	}

	/*
	 * Chia mot dand sach vao thanh N danh sach con vi du: Size =100, N=10 --> 10
	 * list moi list 10 phan tu
	 */
	public static <T> List<List<T>> choppedDevideToN(List<T> list, final int N) {

		if (N <= 1 || list.size() < N) {
			List<List<T>> parts = new ArrayList<List<T>>();
			parts.add(list);
			return parts;
		}
		int n = list.size() / N;
		// So doan can chia
		// if(n>1)
		// n=n-1;
		if (logger.isDebugEnabled())
			logger.debug("list.size():" + list.size() + " / N:" + N + "=" + n);
		return chopped(list, N, n);
	}

	

	public static <T> void shuffleList(List<T> a) {
		int n = a.size();
		Random random = new Random();
		random.nextInt();
		for (int i = 0; i < n; i++) {
			int change = i + random.nextInt(n - i);
			swap(a, i, change);
		}
	}

	private static <T> void swap(List<T> a, int i, int change) {
		T helper = a.get(i);
		a.set(i, a.get(change));
		a.set(change, helper);
	}

	public static <T> void printList(List<T> list) {
		for (T t : list) {
			if (logger.isDebugEnabled())
				logger.debug(t.toString());
		}
	}
}
