package bravo.variachis.showon;

public class Quest1 {

    private int questCount = 0;
    private boolean resolvedQuest;

    public int getQuestCount() {
        return questCount;
    }

    public void setQuestCount(int questCount) {
        this.questCount = questCount;
    }

    public void setResolvedQuest() {
        if (!resolvedQuest) {
            this.resolvedQuest = true;
        } else this.resolvedQuest = true;
        System.out.println("true");
    }

    public boolean checkQuest(){
        if(resolvedQuest == true){
            System.out.println("quest resolved");
            return true;
        }
        System.out.println("quest not resolved");
        return false;

    }

}
