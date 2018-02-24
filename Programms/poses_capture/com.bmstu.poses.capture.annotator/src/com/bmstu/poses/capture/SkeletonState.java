

/* First created by JCasGen Mon Feb 05 13:34:45 MSK 2018 */
package com.bmstu.poses.capture;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;


/**
 * Updated by JCasGen Mon Feb 05 13:34:45 MSK 2018
 * @generated */
public class SkeletonState extends Annotation {
  /** @generated
   * @ordered
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SkeletonState.class);
  /** @generated
   * @ordered
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}

  /** Never called.  Disable default constructor
   * @generated */
  protected SkeletonState() {/* intentionally empty block */}

  /** Internal - constructor used by generator
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure
   */
  public SkeletonState(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   */
  public SkeletonState(JCas jcas) {
    super(jcas);
    readObject();
  }

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA
  */
  public SkeletonState(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }

  /**
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable
   */
  private void readObject() {/*default - does nothing empty block */}



  //*--------------*
  //* Feature: name

  /** getter for name - gets
   * @generated
   * @return value of the feature
   */
  public String getName() {
    if (SkeletonState_Type.featOkTst && ((SkeletonState_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.bmstu.poses.capture.SkeletonState");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SkeletonState_Type)jcasType).casFeatCode_name);}

  /** setter for name - sets
   * @generated
   * @param v value to set into the feature
   */
  public void setName(String v) {
    if (SkeletonState_Type.featOkTst && ((SkeletonState_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "com.bmstu.poses.capture.SkeletonState");
    jcasType.ll_cas.ll_setStringValue(addr, ((SkeletonState_Type)jcasType).casFeatCode_name, v);}
  }

