/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /**
   * Creates a new Arm.
   */
 
  public static WPI_TalonSRX m_armMove;

  public Arm() {
    m_armMove = new WPI_TalonSRX(15);
  }

  public void LiftArmUp() {
    m_armMove.set(ControlMode.PercentOutput, 0.1);
  }

  public void WOFArmUp() {
    m_armMove.set(ControlMode.PercentOutput, 0.1);
  }

  public void ArmDown() {
    m_armMove.set(ControlMode.PercentOutput, -0.1);
  }
}
