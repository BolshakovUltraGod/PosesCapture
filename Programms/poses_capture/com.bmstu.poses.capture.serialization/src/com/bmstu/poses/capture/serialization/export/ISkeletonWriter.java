package com.bmstu.poses.capture.serialization.export;

import java.util.Collection;

import com.bmstu.poses.capture.model.Skeleton;

/**
 *
 * Instances of this class can export skeletons to files.
 *
 * @author Bolshakov
 *
 */
public interface ISkeletonWriter {

	/**
	 *
	 * Exports skeletons to given file.
	 *
	 * @param skeletons - skeletons to export. Can't be <code>null</code>.
	 * @param pathToFile - path to file to export to. Can't be <code>null</code>.
	 */
	void exportSkeletons(Collection<Skeleton> skeletons, String pathToFile);

}
