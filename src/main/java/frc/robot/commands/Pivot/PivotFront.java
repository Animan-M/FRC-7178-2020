/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Pivot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pivot;

public class PivotFront extends CommandBase {
  
  private final Pivot m_Pivot;

  public PivotFront(Pivot subsystem) {
    m_Pivot = subsystem;
    addRequirements(m_Pivot);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(Pivot.m_shootMove.getSelectedSensorPosition() < 5000) {
      m_Pivot.pivotFront();
    } else {
      m_Pivot.stopPivot();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Pivot.m_shootMove.getSelectedSensorPosition() < 5000) {
      return false;
    } else {
      return true;
    }
  }
}
