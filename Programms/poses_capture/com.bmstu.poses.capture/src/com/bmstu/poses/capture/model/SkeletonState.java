package com.bmstu.poses.capture.model;

/**
 *
 * Skeleton state. Contains skeleton and name.
 *
 * @author Bolshakov
 *
 */
public class SkeletonState {
	private String name;
	private Skeleton skeleton;

	/**
	 *
	 * Constructor.
	 *
	 * @param name - name of state. Can't be <code>null</code>.
	 * @param skeleton - associated skeleton. Can't be <code>null</code>.
	 */
	public SkeletonState(String name, Skeleton skeleton) {
		this.name = name;
		this.skeleton = skeleton;
	}

	/**
	 *
	 * Returns state name.
	 *
	 * @return state name. Can't return <code>null</code>.
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * Returns associated skeleton.
	 *
	 * @return associated skeleton. Can't return <code>null</code>.
	 */
	public Skeleton getSkeleton() {
		return skeleton;
	}
}
