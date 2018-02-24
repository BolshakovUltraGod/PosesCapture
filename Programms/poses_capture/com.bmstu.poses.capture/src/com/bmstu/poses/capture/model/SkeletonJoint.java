package com.bmstu.poses.capture.model;

/**
 *
 * Instance of this class represents skeleton joint.
 * Skeleton joins has type, position, and orientation.
 *
 * @author Bolshakov
 *
 */
public class SkeletonJoint {
	private JointType jointType;
	private Point3D position;
	private float positionConfidence;
	private Quaternion orientation;
	private float orientationConfidence;

	/**
	 *
	 * Constructor.
	 *
	 * @param jointType - joint type.
	 * @param position - skeleton joint position. Can't be <code>null</code>
	 * @param positionConfidence - position confidence.
	 * @param orientation - skeleton joint orientation. Can't be <code>null</code>.
	 * @param orientationConfidence - orientation confidence.
	 */
	public SkeletonJoint(int jointType, Point3D position, float positionConfidence, Quaternion orientation, float orientationConfidence) {
		this.jointType = JointType.fromNative(jointType);
		this.position = position;
		this.positionConfidence = positionConfidence;
		this.orientation = orientation;
		this.orientationConfidence = orientationConfidence;
	}

	/**
	 *
	 * Returns joint type.
	 *
	 * @return joint type. Can't return <code>null</code>.
	 */
	public JointType getJointType() {
		return jointType;
	}

	/**
	 *
	 * Returns position.
	 *
	 * @return position. Can't return <code>null</code>.
	 */
	public Point3D getPosition() {
		return position;
	}

	/**
	 *
	 * Returns position confidence.
	 *
	 * @return position confidence. Can't return <code>null</code>.
	 */
	public float getPositionConfidence() {
		return positionConfidence;
	}

	/**
	 *
	 * Returns orientation.
	 *
	 * @return orientation. Can't return <code>null</code>.
	 */
	public Quaternion getOrientation() {
		return orientation;
	}

	/**
	 *
	 * Returns orientation confidence.
	 *
	 * @return orientation confidence. Can't return <code>null</code>.
	 */
	public float getOrientationConfidence() {
		return this.orientationConfidence;
	}
}
