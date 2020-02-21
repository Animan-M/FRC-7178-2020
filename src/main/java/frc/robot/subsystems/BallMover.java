/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallMover extends SubsystemBase {
  /**
   * Creates a new BallMover.
   */
  public static WPI_TalonSRX m_middle;
  public static WPI_TalonSRX m_front;

  public BallMover() {
    m_middle = new WPI_TalonSRX(10);
    m_front = new WPI_TalonSRX(6);
  }

  public void initDefaultCommand() {
    
  }

  public void moveBall(){
    // if(RobotContainer.controller1.getRawButton(9) == true){
    //   BallMover.m_front.set(30);
    //   BallMover.m_middle.set(-20);
    // } else {
    //   BallMover.m_front.set(0);
    //   BallMover.m_middle.set(0);
    // }

  }

  @Override
  public void periodic() {
    if(RobotContainer.controller1.getRawButton(9) == true){
      BallMover.m_front.set(ControlMode.PercentOutput, .3);
      BallMover.m_middle.set(ControlMode.PercentOutput, -.20);
    } else {
      BallMover.m_front.set(ControlMode.PercentOutput, 0);
      BallMover.m_middle.set(ControlMode.PercentOutput, 0);
    }
  }
}
