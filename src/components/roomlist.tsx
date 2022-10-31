import { FC } from "react";

const RoomList:FC = () => {
    return(
<div className="leaderboard">
  <header>
    <h1 className="leaderboard__title leaderboard__title--top">Active Games</h1>
  </header>

  <main className="leaderboard__profiles">
    <div className="leaderboard__profile">
      <img src="https://randomuser.me/api/portraits/men/32.jpg" alt="Mark Zuckerberg" className="leaderboard__picture"/>
      <span className="leaderboard__name">Player 1</span>
    </div>

    <div className="leaderboard__profile">
      <img src="https://randomuser.me/api/portraits/men/97.jpg" alt="Dustin Moskovitz" className="leaderboard__picture"/>
      <span className="leaderboard__name">Player 2</span>
    </div>

    <div className="leaderboard__profile">
      <img src="https://randomuser.me/api/portraits/women/17.jpg" alt="Elizabeth Holmes" className="leaderboard__picture"/>
      <span className="leaderboard__name">Player 3</span>
    </div>

    <div className="leaderboard__profile">
      <img src="https://randomuser.me/api/portraits/men/37.jpg" alt="Evan Spiegel" className="leaderboard__picture"/>
      <span className="leaderboard__name">Player 4</span>
    </div>
  </main>
  </div>
    )
}
export default RoomList;

