package com.bmstu.poses.capture;

import java.util.Collection;

import com.bmstu.poses.capture.model.Skeleton;
import com.bmstu.poses.capture.model.SkeletonState;

/**
 *
 * Instance of this class can identify skeleton state.
 *
 * @author Bolshakov
 *
 */
public interface ISkeletonStateIdentifier {

	/**
	 *
	 * Identifies given skeleton state.
	 *
	 * @param skeleton - skeleton to identify. Can't be <code>null</code>.
	 * @param states - states to choose from. Can't be <code>null</code>.
	 *
	 * @return state of given skeleton (choosen from given <code>states</code>). Can be <code>null</code>.
	 */
	SkeletonState identify(Skeleton skeleton, Collection<SkeletonState> states);

}
