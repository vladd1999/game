import { FC } from "react";
import Card from "../components/CardComponent";
import Player from "../components/player";
import TableCards from "../components/TableCards";

import { Container,TableContainer,Wrapper } from "../styles";

const Table: FC = () => {
    return (
      
      <Container>
        <TableContainer>

            <Player name={"Vlad"}/>
          </TableContainer>
        </Container>
    )
}
export default Table;