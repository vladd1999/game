import { FC } from "react";
import { Link } from "react-router-dom";
import { Container, HomeButtons, HomeContainer, SetNameWrapper, Title } from "../styles";


const Home: FC = () => {
  return (
    <Container>
      <Title>Title</Title>
      <HomeContainer>
        <SetNameWrapper>
          <input placeholder="Enter your name..." />
        </SetNameWrapper>
        <HomeButtons>
          <Link to={"/create"}>Create</Link>
          <Link to={"/join"}>Join</Link>
        </HomeButtons>
      </HomeContainer>
    </Container>
  )
}

export default Home;

