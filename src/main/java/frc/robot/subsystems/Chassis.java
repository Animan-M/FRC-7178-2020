/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Chassis extends SubsystemBase {
  /**
   * Creates a new Chassis.
   */
  private final CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_frontRight = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_backLeft = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax m_backRight = new CANSparkMax(4, MotorType.kBrushless);

  private CANEncoder m_leftEncoder = new CANEncoder(m_frontLeft);
  private CANEncoder m_rightEncoder = new CANEncoder(m_frontRight);

  private final SpeedControllerGroup m_leftMotors;
  private final SpeedControllerGroup m_rightMotors;

  private final DifferentialDrive m_driveType;

  public static double forwards;
  public static double backwards;
  public static double turn;
  public static double move;
  public static double turnDif;
  public static double driveDif;

  public Chassis() {
    m_frontLeft.restoreFactoryDefaults();
    m_frontRight.restoreFactoryDefaults();
    m_backLeft.restoreFactoryDefaults();
    m_backRight.restoreFactoryDefaults();

    m_frontLeft.setSmartCurrentLimit(40);
    m_frontRight.setSmartCurrentLimit(40);
    m_backLeft.setSmartCurrentLimit(40);
    m_backRight.setSmartCurrentLimit(40);

    m_backRight.follow(m_frontRight);
    m_backLeft.follow(m_frontLeft);

    m_leftMotors = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    m_rightMotors  = new SpeedControllerGroup(m_frontRight, m_backRight);


    m_driveType = new DifferentialDrive(m_leftMotors, m_rightMotors);

    m_leftEncoder.setPositionConversionFactor(1.0);
    m_rightEncoder.setPositionConversionFactor(1.0);

    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);

  }

  public void arcadeDrive(double forward, double turn) {
    m_driveType.arcadeDrive(forward, turn);
  }

  public void resetEncoders() {
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public CANEncoder getLeftEncoder() {
    return m_leftEncoder;
  }

  public CANEncoder getRightEncoder() {
    return m_rightEncoder;
  }

  // public double getLeftEncoderPosition() {
  //   return m_leftEncoder.getPosition();
  // }

  // public double getRightEncoderPosition() {
  //   return m_rightEncoder.getPosition();
  // }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("speed", m_leftMotors.get());
    
    // SmartDashboard.putNumber("Front Right NEO", m_frontRight.getOutputCurrent());
    // SmartDashboard.putNumber("Front Left NEO", m_frontLeft.getOutputCurrent());
    // SmartDashboard.putNumber("Back Left NEO", m_backLeft.getOutputCurrent());
    // SmartDashboard.putNumber("Back Right NEO", m_backRight.getOutputCurrent());

    SmartDashboard.putNumber("Right Encoder", m_rightEncoder.getPosition());
    SmartDashboard.putNumber("Left Encoder", m_leftEncoder.getPosition());
  }
  
}
