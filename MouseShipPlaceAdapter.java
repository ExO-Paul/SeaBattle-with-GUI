package Sokolchik.Paul.SeaBattle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by sokolchik_p on 11.09.2014.
 */
public class MouseShipPlaceAdapter implements MouseListener {

    FieldPanel field;
    GamePanel gamePanel;
    Player player, ai;
    boolean shipRotating;
    Ship newShip;
    int strength;
    int shipsCounter;

    public MouseShipPlaceAdapter(GamePanel gamePanel, FieldPanel field, Player player) {
        this.gamePanel = gamePanel;
        this.field = field;
        this.player = player;
        strength = 4;
        shipsCounter = 0;

    }

    public void mouseClicked(MouseEvent e) {
        int yIndex = (int) Math.ceil(e.getX() / field.cellSize);    //swapped coordinates
        int xIndex = (int) Math.ceil(e.getY() / field.cellSize);

        if (Field.inRange(xIndex,yIndex))
            if (!player.getField().getCell(yIndex, xIndex).wasShot && !player.getField().getCell(yIndex, xIndex).occupied){
                if (!shipRotating) {
                    newShip = new Ship();
                    newShip.beginning.x = xIndex;
                    newShip.beginning.y = yIndex;
                    newShip.strength=strength;
                    player.getField().getCell(yIndex, xIndex).wasMarked = true;
                    shipRotating = true;
                } else {

                    if (xIndex == newShip.beginning.x) {
                        if (yIndex == newShip.beginning.y)
                            return;
                        if (yIndex > newShip.beginning.y) {
                            newShip.end.x = newShip.beginning.x;
                            newShip.end.y = newShip.beginning.y + (strength - 1);
                        }
                        if (yIndex < newShip.beginning.y) {
                            newShip.end.x = newShip.beginning.x;
                            newShip.end.y = newShip.beginning.y - (strength - 1);
                        }
                    } else
                    if (yIndex == newShip.beginning.y) {
                        if (xIndex > newShip.beginning.x) {
                            newShip.end.y = newShip.beginning.y;
                            newShip.end.x = newShip.beginning.x + (strength - 1);
                        }
                        if (xIndex < newShip.beginning.x) {
                            newShip.end.y = newShip.beginning.y;
                            newShip.end.x = newShip.beginning.x - (strength - 1);
                        }
                    } else return;
                    if (ShipManipulator.clearCheck(player.getField(), newShip)) {
                        if (shipsCounter == 9) {
                            gamePanel.settingShips = false;
                            System.out.println("Everything's ready");
                        } else if (shipsCounter == 0 || shipsCounter == 2 || shipsCounter == 5)
                            strength--;

                        ShipManipulator.setShip(player.getField(), newShip);
                        player.getField().getShips()[shipsCounter] = newShip;
                        if (shipsCounter == 9) {
                            player.getField().setFieldReady();
                        }
                        shipsCounter++;
                        shipRotating = false;


                        System.out.println("one ready");
                    }
                }
            field.repaint();
        }

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }


}
