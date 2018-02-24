package com.bmstu.poses.capture.model;

/**
 *
 * Instance of this class represents quaternion.
 *
 * @author Bolshakov
 *
 */
public class Quaternion {
	private float x;
	private float y;
	private float z;
	private float w;

	/**
	 *
	 * Constructor.
	 *
	 * @param x - x value.
	 * @param y - y value.
	 * @param z - z value.
	 * @param w - w value.
	 */
	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 *
	 * Returns x value.
	 *
	 * @return x value.
	 */
	public float getX() {
		return x;
	}

	/**
	 *
	 * Returns y value.
	 *
	 * @return y value.
	 */
	public float getY() {
		return y;
	}

	/**
	 *
	 * Returns z value.
	 *
	 * @return z value.
	 */
	public float getZ() {
		return z;
	}

	/**
	 *
	 * Returns w value.
	 *
	 * @return w value.
	 */
	public float getW() {
		return w;
	}
}
