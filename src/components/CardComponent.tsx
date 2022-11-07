import { FC } from "react";


import backCardImg from "../img/cardImg/backCardImg.png";
import heart from "../img/cardImg/heart.png";
import diamond from "../img/cardImg/diamond.png";
import club from "../img/cardImg/club.png";
import spade from "../img/cardImg/spade.png";

import "../style.scss";

interface Props {
  suits?: string,
  card?: string,
  id?:number

}

const Card: FC<Props> = (props) => {

  const { suits, card,id } = props;

  const getCardSymbol = (suits: any) => {
    let symbol;
    switch (suits) {
      case "Diamond":
        return symbol = diamond;
      case "Heart":
        return symbol = heart;
      case "Club":
        return symbol = club;
      case "Spade":
        return symbol = spade;
      default:
        return symbol;
    };
  };
  const getCardColor = (suits: any) => {
    let color;
    switch (suits) {
      case "Diamond":
        return color = "red";
      case "Heart":
        return color = "red";
      case "Club":
        return color = "black";
        case "Spade":
        return color = "black";
      default:
        return color;
    };
  };

  if ( card && suits) {
    const cardSymbol = getCardSymbol(suits);
    const cardColor = getCardColor(suits);
    return (
      <div className={`card-container ${id!==0?"playercard":""}`} style={{ color: cardColor }}>
        <div style={{ position: "absolute", top: 5, left: 5 }}>
          <div style={{ maxWidth: 13 }}>{card}</div>
          <img src={cardSymbol} alt="suit-symbol" style={{ maxWidth: 13 }} />
        </div>
        <div>
          <img src={cardSymbol} alt="suit-symbol" style={{ height: 25, position: "absolute", top: "50%", left: "50%", transform: "translate(-50%, -50%)" }} />
        </div>
        <div style={{ position: "absolute", bottom: 5, right: 5, transform: "rotate(-180deg)" }}>
          <div style={{ maxWidth: 25 }}>{card}</div>
          <img src={cardSymbol} alt="suit-symbol" style={{ maxWidth: 13 }} />
        </div>
      </div>
    );
  } else {
    return (
      <div className="card-container" style={{ backgroundImage: `url(${backCardImg})` }}></div>
    );
  };
};


export default Card;