/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Lift extends SubsystemBase {
  /**
   * Creates a new Lift.
   */

  public static WPI_TalonSRX m_leftLift;
  public static WPI_TalonSRX m_rightLift;
  public static WPI_TalonSRX m_armMove;

  public Lift() {
    m_leftLift = new WPI_TalonSRX(14);
    m_rightLift = new WPI_TalonSRX(13);
    m_armMove = new WPI_TalonSRX(15);
  }

  public void initDefaultCommand() {
    // setDefaultCommand(new teleopLiftUp());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
