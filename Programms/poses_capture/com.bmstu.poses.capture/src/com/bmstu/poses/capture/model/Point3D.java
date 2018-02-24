package com.bmstu.poses.capture.model;

/**
 *
 * Instance of this class represents point with (x, y, z) coordinates.
 *
 * @author Bolshakov
 *
 */
public class Point3D {

	private float x;
	private float y;
	private float z;

	/**
	 *
	 * Constructor
	 *
	 * @param x - x coordinate.
	 * @param y - y coordinate.
	 * @param z - z coordinate.
	 */
	public Point3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 *
	 * Returns x coordinate.
	 *
	 * @return x coordinate.
	 */
	public float getX() {
		return x;
	}

	/**
	 *
	 * Returns y coordinate.
	 *
	 * @return y coordinate.
	 */
	public float getY() {
		return y;
	}

	/**
	 *
	 * Returns z coordinate.
	 *
	 * @return z coordinate.
	 */
	public float getZ() {
		return z;
	}
}
