package dev.caua.endersurvival.votifier;

import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import dev.caua.endersurvival.EnderSurvival;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class VoteReceived implements Listener {

    @EventHandler
    public void onVotifierEvent(VotifierEvent event) {
        Vote vote = event.getVote();
        EnderSurvival.getVoteReward().giveReward(vote.getUsername(), vote.getServiceName());
        EnderSurvival.getVoteParty().addVote();
    }
}
