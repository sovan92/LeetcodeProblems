package com.sovanleetcode.design.hitcounter;

import java.util.ArrayList;
import java.util.List;

public class BasicHitCounterList {

	/** Initialize your data structure here. */

	List<Integer> hitStamp = null;

	public BasicHitCounterList() {
		hitStamp = new ArrayList<Integer>();
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {

		hitStamp.add(timestamp);

	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int i = 0;
		for (i = 0; i < hitStamp.size(); i++) {
			if (hitStamp.get(i) > (timestamp - 300)) {
				break;
			}
		}

		return hitStamp.size() - i;

	}

}
