import React from 'react'
import { Container, Row, Col } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const Pagenotfound = () => {
  return (
    <Container>
      <Row>
        <Col>
          <div class="text-center">
            <div className="pnf">
              <h1 className="pnf-title">404</h1>
              <h2 className="pnf-heading">Oops ! Page Not Found</h2>
              <Link to="/" className="pnf-btn">
                Go Back
              </Link>
            </div>
          </div>
        </Col>
      </Row>
    </Container>
  )
}

export default Pagenotfound
