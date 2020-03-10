/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shoot extends SubsystemBase {
  /**
   * Creates a new Shoot.
   */
  public static WPI_TalonSRX m_topShoot;
  public static WPI_TalonSRX m_bottomShoot;
  public static Solenoid m_ballPush;

  public Shoot() {
    m_topShoot = new WPI_TalonSRX(8);
    m_bottomShoot = new WPI_TalonSRX(7);
    m_ballPush = new Solenoid(19, 0); //can id, pcm channel

    m_topShoot.setNeutralMode(NeutralMode.Coast);
    m_bottomShoot.setNeutralMode(NeutralMode.Coast);
  }

  public void Shooter() {
    m_topShoot.set(ControlMode.PercentOutput, -1);
    m_bottomShoot.set(ControlMode.PercentOutput, 1);
  }

  public void stopShooter() {
    m_topShoot.set(ControlMode.PercentOutput, 0);
    m_bottomShoot.set(ControlMode.PercentOutput, 0);
  }

  public void speedControlShooter(double speedTarget){
    m_topShoot.set(ControlMode.Velocity, -speedTarget);
    m_bottomShoot.set(ControlMode.Velocity, speedTarget);
  }

  public double getShooterVelocity(){
    int sensorVelocityTop = m_topShoot.getSelectedSensorVelocity(0);
    int sensorVelocityBottom = m_bottomShoot.getSelectedSensorVelocity(0);
    double vel_RotPerSecTop = (double)sensorVelocityTop / 2048 * 10;
    double vel_RotPerSecBottom = (double)sensorVelocityBottom / 2048 * 10;
    double vel_AvgRotPerSec = vel_RotPerSecBottom + (-vel_RotPerSecTop) / 2; 
    double vel_RotPerMin = vel_AvgRotPerSec * 60.0;

    return vel_RotPerMin;

  }

  public void ballPushIn() {
    m_ballPush.set(true);
  }

  public void ballPushOut() {
    m_ballPush.set(false);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Top Velocity", m_topShoot.getSelectedSensorVelocity());
    SmartDashboard.putNumber("Bottom Velocity", m_bottomShoot.getSelectedSensorVelocity());
    
  }
}
