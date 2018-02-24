package com.bmstu.poses.capture.model;

import java.util.NoSuchElementException;

/**
 *
 * Joint type enum.
 *
 * @author Bolshakov
 *
 */
public enum JointType {

	HEAD(0),
	NECK(1),
	LEFT_SHOULDER(2),
	RIGHT_SHOULDER(3),
	LEFT_ELBOW(4),
	RIGHT_ELBOW(5),
	LEFT_HAND(6),
	RIGHT_HAND(7),
	TORSO(8),
	LEFT_HIP(9),
	RIGHT_HIP(10),
	LEFT_KNEE(11),
	RIGHT_KNEE(12),
	LEFT_FOOT(13),
	RIGHT_FOOT(14);

	private final int value;

	public static JointType fromNative(int value) {
		for (JointType localJointType : JointType.values()) {
			if (localJointType.toNative() == value) {
				return localJointType;
			}
		}

		throw new NoSuchElementException();
	}

	private JointType(int value) {
		this.value = value;
	}

	public int toNative() {
		return value;
	}
}
