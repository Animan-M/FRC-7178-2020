package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.BallMove.BallForward;
import frc.robot.commands.Drive.DriveDistance;
import frc.robot.commands.Shoot.BallPushIn;
import frc.robot.commands.Shoot.Shooter;
import frc.robot.subsystems.BallMover;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Shoot;
/**
 * A complex auto command that starts the shooter Aims, Shoots Balls drives forward
 */
public class AutoDriveForward extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param indexer The indexer subsystem this command will run on
   * @param shooter The shooter subsystem this command will run on
   */
  public AutoDriveForward(Chassis drive, BallMover indexer, Shoot BallShoot) {
    addCommands(
        new SequentialCommandGroup(
          // new DriveDistance(0.0,drive),
          new Shooter(BallShoot),
          new WaitCommand(7),
          new BallPushIn(BallShoot),
          new WaitCommand(0.5),
          new BallForward(indexer),
          // new WaitCommand(5),
          new WaitCommand(2),
          new DriveDistance(
            -50,
            -0.5,
            drive),
          new WaitCommand(4)        
        )
      );
  }

}
