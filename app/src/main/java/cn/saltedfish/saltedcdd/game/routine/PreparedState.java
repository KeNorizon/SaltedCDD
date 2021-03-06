package cn.saltedfish.saltedcdd.game.routine;

import cn.saltedfish.saltedcdd.game.GameState;
import cn.saltedfish.saltedcdd.game.IGameOperationBridge;
import cn.saltedfish.saltedcdd.game.Player;
import cn.saltedfish.saltedcdd.game.card.ECardNumber;
import cn.saltedfish.saltedcdd.game.card.ECardSuit;

public class PreparedState extends GameState {
    @Override
    public void onEnterState(IGameOperationBridge pGame)
    {
        pGame.onPrepared();
    }

    @Override
    public void onStartGame(IGameOperationBridge pGame)
    {
        if (pGame.isInState(PreparedState.class))
        {
            Player firstPlayer = decideFirstPlayer(pGame);

            pGame.enterState(RoundHeadState.class);
            pGame.setCurrentTurnedPlayer(firstPlayer);
        }
    }

    protected Player decideFirstPlayer(IGameOperationBridge pGame)
    {
        for (int i = 0; i < FourPlayerGame.PlayerCount; i++)
        {
            Player player = pGame.getPlayer(i);
            if (player.hasCard(ECardNumber.NUM_3, ECardSuit.DIAMOND))
            {
                return player;
            }
        }
        return null;
    }
}
