/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pivot extends SubsystemBase {
  
  public static WPI_TalonSRX m_shootMove;
  public static DigitalInput _pivotUp = new DigitalInput(5);
  public int shootMin = 0;
  public int shootMax = 0;

  private boolean closeSpot = false;
  
  public Pivot() {
    m_shootMove = new WPI_TalonSRX(11);
    m_shootMove.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    m_shootMove.setSelectedSensorPosition(0);
  }

  public void resetEncoder() {
    m_shootMove.setSelectedSensorPosition(0);
  }

  public void AutoPivotUp() {
    if(Pivot.m_shootMove.getSelectedSensorPosition() > 175) {
      m_shootMove.set(ControlMode.PercentOutput, -0.15);
    } else if(Pivot.m_shootMove.getSelectedSensorPosition() < 155) {
      m_shootMove.set(ControlMode.PercentOutput, 0.15);
    } else {
      m_shootMove.set(ControlMode.PercentOutput, 0);
    }
  }

  public void pivotFront() {
    m_shootMove.set(ControlMode.PercentOutput, 0.15);
  }

  public void pivotBack() {
    m_shootMove.set(ControlMode.PercentOutput, -0.15);
  }

  public void stopPivot() {
    m_shootMove.set(ControlMode.PercentOutput, 0);
  }
  
  public double pivotPosition() {
    int position = m_shootMove.getSelectedSensorPosition();

    return position;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Pivot Rotation", (m_shootMove.getSelectedSensorPosition()/10));
    SmartDashboard.putNumber("Shoot Max", shootMax/10);
    SmartDashboard.putNumber("Shoot Min", shootMin/10);
    SmartDashboard.putBoolean("Pivot Spot", _pivotUp.get());
    SmartDashboard.putBoolean("Wall", closeSpot);

    if(((m_shootMove.getSelectedSensorPosition()/10)) > 155 && ((m_shootMove.getSelectedSensorPosition()/10)) < 175) {
     closeSpot = true; 
    } else {
      closeSpot = false;
    }

    // if(shootMin == 0 && shootMax == 0) {
    //   if(_pivotUp.get() == true) {
    //     shootMin = -m_shootMove.getSelectedSensorPosition();
    //     shootMax = m_shootMove.getSelectedSensorPosition();
    //     resetEncoder();
    //   }
    // }

    // if(!_pivotUp.get()){
    //   resetEncoder();
    // }
  }
}
