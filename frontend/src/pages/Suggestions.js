import React, { useState, useEffect } from 'react';
import { useSearchParams } from 'react-router-dom';
import { Typography, TextField, Button, Box, Alert, Card, CardContent, Avatar } from '@mui/material';
import axios from 'axios';

function Suggestions() {
  const [searchParams] = useSearchParams();
  const placeId = searchParams.get('place');
  const [place, setPlace] = useState(null);
  const [title, setTitle] = useState('');
  const [text, setText] = useState('');
  const [success, setSuccess] = useState(false);
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (placeId) {
      axios.get(`http://localhost:8080/api/places/${placeId}`)
        .then(res => setPlace(res.data));
    }
  }, [placeId]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(false);
    setSuccess(false);
    setLoading(true);
    try {
      await axios.post('http://localhost:8080/api/suggestions', {
        title,
        text,
        place: placeId ? { id: Number(placeId) } : undefined
      });
      setSuccess(true);
      setText('');
      setTitle('');
    } catch {
      setError(true);
    }
    setLoading(false);
  };

  return (
    <Box sx={{ maxWidth: 500, mx: 'auto', mt: 4 }}>
      <Card>
        <CardContent>
          <Typography variant="h5" gutterBottom>Add a Suggestion</Typography>
          {place && (
            <Box sx={{ display: 'flex', alignItems: 'center', mb: 2 }}>
              <Avatar sx={{ mr: 2 }} src={place.logo || undefined}>{place.name[0]}</Avatar>
              <Box>
                <Typography variant="subtitle1">For: {place.name}</Typography>
                <Typography variant="body2" color="text.secondary">{place.description}</Typography>
              </Box>
            </Box>
          )}
          <form onSubmit={handleSubmit}>
            <TextField
              label="Title"
              value={title}
              onChange={e => setTitle(e.target.value)}
              fullWidth
              required
              sx={{ mb: 2 }}
            />
            <TextField
              label="Your Suggestion"
              value={text}
              onChange={e => setText(e.target.value)}
              fullWidth
              required
              multiline
              minRows={2}
              sx={{ mb: 2 }}
            />
            <Button type="submit" variant="contained" disabled={loading} fullWidth>
              {loading ? 'Submitting...' : 'Submit'}
            </Button>
          </form>
          {success && <Alert severity="success" sx={{ mt: 2 }}>Suggestion submitted!</Alert>}
          {error && <Alert severity="error" sx={{ mt: 2 }}>Failed to submit. Try again.</Alert>}
        </CardContent>
      </Card>
    </Box>
  );
}

export default Suggestions; 