/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallPickup extends SubsystemBase {
  /**
   * Creates a new BallPickup.
   */
  public static WPI_TalonSRX m_pickup;
  public static WPI_TalonSRX m_back;
  public static Solenoid m_pushOut;
  public static Compressor m_AirCompressor;

  public BallPickup() {
    m_back = new WPI_TalonSRX(9);
    m_pickup = new WPI_TalonSRX(5);
    m_AirCompressor = new Compressor(19);

    m_pushOut = new Solenoid(19, 1); //can id, pcm channel 
  }

  public void initDefaultCommand() {

  }

  public void ballUp() {
    m_back.set(ControlMode.PercentOutput, 1);
    m_pickup.set(ControlMode.PercentOutput, .7);
  }

  public void ballStop() {
    m_back.set(ControlMode.PercentOutput, 0);
    m_pickup.set(ControlMode.PercentOutput, 0);
  }

  public void deployPickup() {
    m_pushOut.set(true);
  }

  public void retractPickup() {
    m_pushOut.set(false);
  }

}
