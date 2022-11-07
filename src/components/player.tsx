import { FC } from "react";
import { CardsContainer, PlayerContainer, ProfileImg } from "../styles";
import profile from "../img/profile.jpg";
import Card from "./CardComponent";
interface Props {
    name: string;

}

const Player: FC<Props> = (props) => {
    const name = props.name;
    return (
    <PlayerContainer style={{ display:"table", alignContent:"center", justifyContent:"center", textAlign: "center"}}>

    <div >
        <ProfileImg src={profile} alt="user-profile-pic" />
    </div>
        <span>{name}</span>
        <CardsContainer >
        <Card suits={"Heart"} card={"5"}  id={0} />
            <Card suits={"Heart"} card={"8"}  id={1} />
            <Card suits={"Spade"} card={"3"} id={1} />
            <Card suits={"Heart"} card={"2"} id={1} />
            <Card suits={"Club"} card={"Q"} id={1} />
            <Card id={2} />
            <Card suits={"Diamond"} card={"9"}  id={1} />
        </CardsContainer>
            
    </PlayerContainer>
    )
}
export default Player;