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
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Chassis extends SubsystemBase {
  /**
   * Creates a new Chassis.
   */
  public static CANSparkMax m_frontLeft;
  public static CANSparkMax m_frontRight;
  public static CANSparkMax m_backLeft;
  public static CANSparkMax m_backRight; 

  public static SpeedControllerGroup m_leftMotors;
  public static SpeedControllerGroup m_rightMotors;

  public static DifferentialDrive m_driveType;

  public static double forwards;
  public static double backwards;
  public static double turn;
  public static double move;
  public static double turnDif;
  public static double driveDif;

  public Chassis() {
    m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
    m_frontRight = new CANSparkMax(2, MotorType.kBrushless);
    m_backLeft = new CANSparkMax(3, MotorType.kBrushless);
    m_backRight = new CANSparkMax(4, MotorType.kBrushless);
    m_frontLeft.restoreFactoryDefaults();
    m_frontRight.restoreFactoryDefaults();
    m_backLeft.restoreFactoryDefaults();
    m_backRight.restoreFactoryDefaults();
    m_frontLeft.setSmartCurrentLimit(40);
    m_frontRight.setSmartCurrentLimit(40);
    m_backLeft.setSmartCurrentLimit(40);
    m_backRight.setSmartCurrentLimit(40);

    m_leftMotors = new SpeedControllerGroup(m_frontLeft, m_backLeft);
    m_rightMotors  = new SpeedControllerGroup(m_frontRight, m_backRight);

    m_driveType = new DifferentialDrive(m_leftMotors, m_rightMotors);
  }

  public void ChassisSetup() {
    m_backRight.follow(m_frontRight);
    m_backLeft.follow(m_frontLeft);
  }

  public void arcadeDrive(double forward, double turn) {
    m_driveType.arcadeDrive(forward, turn);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Front Right NEO", m_frontRight.getOutputCurrent());
    SmartDashboard.putNumber("Front Left NEO", m_frontLeft.getOutputCurrent());
    SmartDashboard.putNumber("Back Left NEO", m_backLeft.getOutputCurrent());
    SmartDashboard.putNumber("Back Right NEO", m_backRight.getOutputCurrent());
  }
  
}
