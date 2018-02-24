package com.bmstu.poses.capture;

import java.util.Collection;

import com.bmstu.poses.capture.model.JointType;
import com.bmstu.poses.capture.model.Point3D;
import com.bmstu.poses.capture.model.Quaternion;
import com.bmstu.poses.capture.model.Skeleton;
import com.bmstu.poses.capture.model.SkeletonJoint;
import com.bmstu.poses.capture.model.SkeletonState;

/**
 *
 * Default implementation of {@link ISkeletonStateIdentifier}.
 *
 * @author Bolshakov
 *
 */
public class DefaultSkeletonStateIdentifier implements ISkeletonStateIdentifier {

	private static final float MAXIMUM_OFFSET = 0.1f;

	@Override
	public SkeletonState identify(Skeleton skeleton, Collection<SkeletonState> states) {
		for (SkeletonState state : states) {
			if (inBounds(skeleton, state)) {
				return state;
			}
		}

		return null;
	}

	private boolean inBounds(Skeleton skeleton, SkeletonState state) {
		for (int jointIndex = 0; jointIndex < JointType.values().length; jointIndex++)
		{
			if (!inBounds(skeleton.getJoints().get(jointIndex), state.getSkeleton().getJoints().get(jointIndex)))
			{
				return false;
			}
		}


		return true;
	}

	private boolean inBounds(SkeletonJoint skeletonJoint, SkeletonJoint stateJoint) {
		return inBounds(skeletonJoint.getPosition(), stateJoint.getPosition())
				&& inBounds(skeletonJoint.getOrientation(), stateJoint.getOrientation());
	}

	private boolean inBounds(Point3D position, Point3D statePosition) {
		return Math.abs(position.getX() - statePosition.getX()) < MAXIMUM_OFFSET
				&& Math.abs(position.getY() - statePosition.getY()) < MAXIMUM_OFFSET
				&& Math.abs(position.getZ() - statePosition.getZ()) < MAXIMUM_OFFSET;
	}

	private boolean inBounds(Quaternion orientation, Quaternion stateOrientation) {
		return Math.abs(orientation.getX() - stateOrientation.getX()) < MAXIMUM_OFFSET
				&& Math.abs(orientation.getY() - stateOrientation.getY()) < MAXIMUM_OFFSET
				&& Math.abs(orientation.getZ() - stateOrientation.getZ()) < MAXIMUM_OFFSET
				&& Math.abs(orientation.getW() - stateOrientation.getW()) < MAXIMUM_OFFSET;
	}

}
