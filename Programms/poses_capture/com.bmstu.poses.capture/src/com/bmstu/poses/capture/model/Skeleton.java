package com.bmstu.poses.capture.model;

import java.util.List;

/**
 *
 * Instance of this class represents skeleton.
 * Skeleton contains skeleton joints.
 *
 * @author Bolshakov
 *
 */
public class Skeleton {

	private List<SkeletonJoint> joints;

	/**
	 *
	 * Constructor.
	 *
	 * @param joints - skeleton joints. Should contains all {@link JointType joint types}. Can't be <code>null</code>.
	 */
	public Skeleton(List<SkeletonJoint> joints) {
		if (joints.size() != JointType.values().length) {
			throw new IllegalStateException("Skeleton joints should contain all joint types");
		}

		this.joints = joints;
	}

	/**
	 *
	 * Returns joints.
	 *
	 * @return joints. Can't return <code>null</code>.
	 */
	public List<SkeletonJoint> getJoints() {
		return joints;
	}
}
